///<script src="../../../assets/js/angular.js"></script
///<script src="../../../assets/js/angular-route.js"></script> 


app.config(['$routeProvider',function($routeProvider) {
	$routeProvider

	.when('/',{

		templateUrl:"apps/components/views/login/login.html",
		controller:"userController",
		controllerAs:"userCtrl"
		
			})
	
	.when('/home/',{

		templateUrl:"apps/components/views/home/home.html",
		controller:"homeController",
		
			})

	

	.when('/blog/',{

		templateUrl:"apps/components/views/blog/blog.html",
		controller:"blogController",
		controllerAs:"blogCtrl"
		
			})

	.when('/forum/',{

		templateUrl:"apps/components/views/forum/forum.html",
		controller:"forumController",
		controllerAs:"forumCtrl"
		
			})

	.when('/forums/forumView/:forum_id',{

		templateUrl:"apps/components/views/forum/forumView.html",
		controller:"forumViewController",
		controllerAs:"forumViewCtrl"
		
			})

	.when('/event/',{

		templateUrl:"apps/components/views/event/event.html",
		controller:"eventController",
		controllerAs:"eventCtrl"
		    })

	.when('/jobOpportunities/',{

		templateUrl:"apps/components/views/job/job.html",
		controller:"jobController",
		controllerAs:"jobCtrl"

		    })

	
	
}]);