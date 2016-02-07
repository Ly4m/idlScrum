/**
 * @ngdoc directive
 * @name scrumboard:sbTask
 *
 * @description
 *
 *
 * @restrict E
 * */
angular.module('scrumboard')
    .directive('sbTask', function () {
        return {
            restrict: 'E',
            templateUrl: 'templates/scrumBoard/task.html',
            scope: {
                header: "=",
                description: "="
            }
        };
    });
