var app = angular.module("LogInManagement", ["SignUpManagement"]);

app.controller("LogInController", function($scope, $http) {
	//$scope.roleWarning = false;
	$scope.usernameWarning = false;
	$scope.passwordWarning = false;
	
	$scope.user = {};
	$scope.roleType = "Buyer";
}