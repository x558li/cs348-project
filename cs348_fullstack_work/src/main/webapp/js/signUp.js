
var app = angular.module("SignUpManagement", []);

app.controller("SignUpController", function($scope, $http) {
	$scope.usernameWarning = false;
	$scope.passwordWarning = false;
	
	$scope.user = {};
	$scope.roleType = "Buyer";

	$scope.submitUser = function() {
		//check if username is valid
		$scope.checkUserExists($scope.user.username).then(function feedback(response) {
			if (response.exists == true) { //user already exists
				$scope.usernameWarning = true;
			}
		});

		//check passwords match
		if ($scope.user.password !== $scope.confirmPassword) {
			$scope.passwordWarning = true;
		}

		//get user role type;
		$scope.checkRadioBtn();
		$scope.user.roleType = $scope.roleType;

		//sent repquest
		if ($scope.usernameWarning != true && $scope.passwordWarning != true) {
			$scope.submitUser_backend($scope.user);
		}

		//set back values
		$scope.usernameWarning = false;
		$scope.passwordWarning = false;
		$scope.user = {};
		$scope.roleType = "Buyer";
	}

	$scope.checkRadioBtn = function() {
		if (document.getElementById("buyerRadio").checked == true) {
			$scope.roleType = "Buyer";
		} else if (document.getElementById("manufacturerRadio").checked == true) {
			$scope.roleType = "Manufacturer";
		}
	}

	$scope.checkUserExists = function(username) {
		$http({
            method : "GET",
            url : 'user/checkUserExists/username=' + username,
            headers : {
                'Content-Type' : 'application/json'
            }
        });/*.then(function successCallback(response) {
		    console.log("User '" + username + "' Created Successfully.");
	  	}, function errorCallback(response) {
	     	$scope.usernameWarning = true;
	     	console.log("User '" + username + "' is taken or invalid.");
	  	}); */  
	}

	$scope.submitUser_backend = function(user) {
         
        var method = "";
        var url = "";

        method = "POST";
        url = 'user/addNewUser';

        $http({
            method : method,
            url : url,
            data : angular.toJson(user),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
		    console.log("New User Created Successfully.");
	  	}, function errorCallback(response) {
	     	console.log("Failed to Create New User.");
	  	});   
    };

		
});