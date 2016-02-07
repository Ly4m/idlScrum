/**
 * @ngdoc controller
 * @name scrumboard:TasksCtrl
 *
 * @description
 *
 *
 * @requires $scope
 * */
angular.module('scrumboard')
    .controller('TasksCtrl', function ($scope, $http) {

        $scope.states = [
            "To do",
            "Doing",
            "Done",
            "Regression"
        ];

        $scope.newTask = {};

        $scope.refresh = function () {

            $http.get("/story/all").success(function (data) {

                $scope.stories = data;

            });

        };

        $scope.refresh();

        $scope.addTask = function () {

            $scope.newTask.state = 0;

            $http.post("/task", $scope.newTask).success(function () {
                $scope.newTask = {};
                $scope.refresh();
            });
        }

    });
