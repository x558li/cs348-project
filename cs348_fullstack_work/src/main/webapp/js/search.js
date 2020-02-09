var app = angular.module("SearchManagement", []);

//Controller Part
app.controller("SearchController", function($scope, $http) {
    $scope.modelList = ["All"];
    $scope.yearList = ["All"];
    $scope.makeList = ["All"];

    $scope.searchCriteria = {};


    $scope.selectMakeWarning = true;
    //"/getAllFuelConsumptions"
    /*$scope.showWarning = function() {
        $(".select-make-warning").show(10,1);
        $(".select-make-warning").fadeTo(10,0);
    }*/

    $scope.getModelList().then(function(response) {
        $scope.modelList = response.modelList;
    })

    $scope.getModelList = function() {
        $http({
            method : "GET",
            url : 'search/getAllModels',
            headers : {
                'Content-Type' : 'application/json'
            }
        });
    }

    $scope.getSearchCriteria = function() {
        var e = document.getElementById("model");
        $scope.selecedModel = e.options[e.selectedIndex].value;
        e = document.getElementById("year");
        $scope.selecedYear = e.options[e.selectedIndex].value;
        e = document.getElementById("make");
        $scope.selecedMake = e.options[e.selectedIndex].value;
        e = document.getElementById("priceFrom");
        $scope.selecedPrice[0] = e.options[e.selectedIndex].value;
        e = document.getElementById("priceTo");
        $scope.selecedPrice[1] = e.options[e.selectedIndex].value;

        $scope.searchCriteria.model = $scope.selecedModel;
        $scope.searchCriteria.year = $scope.selecedYear;
        $scope.searchCriteria.make = $scope.selecedMake;
        $scope.searchCriteria.priceFrom = $scope.selecedPrice[0];
        $scope.searchCriteria.priceTo = $scope.selecedPrice[1];
    }
  
});