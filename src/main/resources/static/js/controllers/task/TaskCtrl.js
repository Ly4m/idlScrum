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
    .controller('TaskCtrl', function($scope, $http, $routeParams){

            $http.get('/task/' + $routeParams.id).success(function(data){
                    $scope.task = data;
            });




});
