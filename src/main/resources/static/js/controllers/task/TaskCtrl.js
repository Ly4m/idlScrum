/**
 * @ngdoc controller
 * @name scrumboard:TaskCtrl
 *
 * @description
 *
 *
 * @requires $scope
 * */
angular.module('scrumboard')
    .controller('TaskCtrl', function ($scope, $http, $routeParams) {

        $scope.modify = true;

        $http.get('/task/' + $routeParams.id).success(function (data) {
            $scope.task = data;
        });

        $http.get('/user/all').success(function (data) {
            $scope.users = data;
        });

        $scope.triggerModify = function () {
            $scope.modify = !$scope.modify;
        };

        $scope.save = function () {
            $http.put('/task/', $scope.task).success(function (data) {
                console.debug(JSON.stringify(data));

                $scope.triggerModify();

            });
        }

    });
