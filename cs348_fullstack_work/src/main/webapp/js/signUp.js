
var app = angular.module("SignUpManagement", []);

app.controller("SignUpController", function($scope, $http) {
	$scope.roleWarning = true;
	$scope.usernameWarning = true;
	$scope.passwordWarning = true;
});