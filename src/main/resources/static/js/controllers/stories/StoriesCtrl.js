/**
 * @ngdoc controller
 * @name scrumboard:StoriesCtrl
 *
 * @description
 *
 *
 * @requires $scope
 * */
angular.module('scrumboard')
    .controller('StoriesCtrl', function ($scope, $http) {

        $scope.newStory = {};

        $scope.refresh = function () {
            $http.get("/story/all").success(function (data) {

                $scope.stories = data;

            });
        };

        $scope.addStory = function () {

            $http.post("/story", $scope.newStory).success(function(data){
               console.debug(JSON.stringify(data));
                $scope.newStory = {};
                $scope.refresh();
            });

        };

        $scope.refresh();


    });
