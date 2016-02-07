angular.module('scrumboard')
    .controller('ScrumBoardCtrl', function ($scope, $http, $location) {

        $http.get("/story/all").success(function(data){

            $scope.stories = data;

        });

        $http.get("/test/all").success(function(data){



        });

    });