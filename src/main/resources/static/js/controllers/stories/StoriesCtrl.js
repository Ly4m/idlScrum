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

            $http.post("/story", $scope.newStory).success(function (data) {
                $scope.newStory = {};
                $scope.refresh();
            });

        };

        $scope.deleteStory = function (id) {

            var url = "/story/delete/" + id;

            $http({
                method: "delete",
                url: url
            }).success(function (data) {
                $scope.refresh();
            });
        };

        $scope.refresh();


    })
;
