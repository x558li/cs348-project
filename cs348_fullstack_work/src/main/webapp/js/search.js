            var app = angular.module("CustomerManagement", []);
         
            //Controller Part
            app.controller("CustomerController", function($scope, $http) {
         
               
                $scope.customers = [];
                $scope.customerForm = {
                    id : -1,
                    customerName : "",
                    email : ""
                };
         
                //Now load the data from server
                _refreshCustomerData();
         
                //HTTP POST/PUT methods for add/edit customer 
                // with the help of id, we are going to find out whether it is put or post operation
                
                $scope.submitCustomer = function() {
         
                    var method = "";
                    var url = "";
                    if ($scope.customerForm.id == -1) {
                        //Id is absent in form data, it is create new customer operation
                        method = "POST";
                        url = '/addCustomer';
                    } else {
                        //Id is present in form data, it is edit customer operation
                        method = "PUT";
                        url = '/addCustomer';
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.customerForm),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then( _success, _error );
                };
         
                //HTTP DELETE- delete customer by Id
                $scope.deleteCustomer = function(customer) {
                    $http({
                        method : 'DELETE',
                        url : '/deleteCustomer/' + customer.id
                    }).then(_success, _error);
                };
 
             // In case of edit, populate form fields and assign form.id with customer id
                $scope.editCustomer = function(customer) {
                  
                    $scope.customerForm.customerName = customer.customerName;
                    $scope.customerForm.email = customer.email;
                    $scope.customerForm.id = customer.id;
                };
         
                /* Private Methods */
                //HTTP GET- get all customers collection
                function _refreshCustomerData() {
                    $http({
                        method : 'GET',
                        url : 'http://localhost:8080/getAllCustomers'
                    }).then(function successCallback(response) {
                        $scope.customers = response.data;
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshCustomerData();
                    _clearFormData()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearFormData() {
                    $scope.customerForm.id = -1;
                    $scope.customerForm.customerName = "";
                    $scope.customerForm.email = "";
                
                };
            });