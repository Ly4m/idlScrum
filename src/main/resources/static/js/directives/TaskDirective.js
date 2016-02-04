/**
 * @ngdoc directive
 * @name scrumboard:TaskDirective
 *
 * @description
 *
 *
 * @restrict E
 * */
angular.module('scrumboard')
    .directive('taskDirective', function () {
        return {
            restrict: 'E',
            templateUrl: 'js/templates/scrumBoard/task.html',
            controller: 'TaskCtrl'
        };
    });
