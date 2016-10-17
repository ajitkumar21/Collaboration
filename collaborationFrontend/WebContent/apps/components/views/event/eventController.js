var event=angular.module('collaborationAppEvent',['controllerEventservice','ngRoute']);
event.controller('eventController',[ '$scope','EventService','$http',function($scope,EventService,$http){
	var self=this;
	self.event={event_id:'',eventName:'',description:''}
	self.events=[];

	self.submit = submit;
	self.edit=edit;
	self.remove=remove;
	self.reset=reset;


	fetchAllEvent();
	function fetchAllEvent(){
		EventService
		.fetchAllEvent()
		.then(function(data){
			self.events=data;
		},function (errResponse) {
			console.error('Error while fetching the events');
		}
		);
	}

	function createEvent(event){
		EventService
		.createEvent(event)
		.then(
			fetchAllEvent,
			function(errResponse){
				console.error('Error while creating event');
			}
			);
	}

	function updateEvent(event, event_id){
		EventService
		.updateEvent(event, event_id)
		.then(
			fetchAllEvent,
			function(errResponse){
				console.error('Error while updating Event');
			}
			);
	}

	function deleteEvent(event_id){
		EventService
		.deleteEvent(event_id)
		.then(
			fetchAllEvent,
			function(errResponse){
				console.error('Error while deleting Event');
			}
			);
	}
	function submit() {
	/*	if(self.event.event_id===''){
			console.log('Saving New event', self.event);
			createEvent(self.event);
		}else{
			console.log('Event updated with event_id ', self.event.event_id);
			updateEvent(self.event, self.event.event_id);
		}

		reset(); 

		*/

		if(self.event.event_id===''){
						var file = self.myFile;
			/* console.log('file is ' );
			console.dir(file);*/
			var uploadUrl = "http://localhost:8080/collaborationBackend/user/saveUserDataAndFile/";
			var fd = new FormData();
			fd.append('file', file);
			fd.append('event',angular.toJson(self.event,true));
			console.log('Socpe of event'+self.event);
			$http.post(uploadUrl, fd, {
				transformRequest : angular.identity,
				headers : {
					'Content-Type' : undefined
				}
			}).success(function() {
				console.log('success');
			}).error(function() {
				console.log('error');
			});		
}
else{
	console.log('Event updated with event_id ', self.event.event_id);
	updateEvent(self.event, self.event.event_id);
}
		
	reset();
}

	function edit(event_id){
		console.log('id to be edited', event_id);
		for(var i = 0; i < self.events.length; i++){
			if(self.events[i].event_id === event_id) {
				self.event= angular.copy(self.events[i]);
				break;
			}
		}
	}
	function remove(event_id){
		console.log('id to be deleted', event_id);
        if(self.event.event_id === event_id) {//clean form if the event to be deleted is shown there.
        	reset();
        }
        deleteEvent(event_id);
    }
    function reset(){
    	self.event={event_id:'',description:'',eventName:''};
        $scope.myForm.$setPristine(); //reset Form
    }
    
}]);