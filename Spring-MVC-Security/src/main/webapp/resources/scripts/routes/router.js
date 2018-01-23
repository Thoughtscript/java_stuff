'use strict';

angularApp
	.config(function ($routeProvider) {
		$routeProvider
			.when('/index', {
				controller: 'indexController'
			})
			.when('/login', {
				controller: 'loginController'
			})
			.when('/success', {
				controller: 'successController'
			})
			.otherwise('/index');
	});