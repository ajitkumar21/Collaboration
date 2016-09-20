///<script src="../../../assets/js/angular.js"></script
///<script src="../../../assets/js/angular-route.js"></script> 


app.config(['$routeProvider',function($routeProvider) {
	$routeProvider
	.when('/home/',{

		templateUrl:"apps/components/views/homeView.html",
		controller:"homeController",
		
			})

	.when('/blog/',{

		templateUrl:"apps/components/views/blogView.html",
		controller:"blogController",
		
			})

	.when('/forum/',{

		templateUrl:"apps/components/views/forum/forumView.html",
		controller:"forumController",
		
			})
	
}]);