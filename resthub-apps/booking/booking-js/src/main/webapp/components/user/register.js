define(['jquery.controller'], function() {
(function($)
{
	$.widget("booking.userRegister", $.ui.controller, {
		_init: function() {

			this.options.context.title('Register');
			this._render();

			var self = this;
			$('#register-button').bind('click', function() {
				var user = {
					email: $('input[name=email]').val(),
					username: $('input[name=username]').val(),
					password: $('input[name=password]').val(),
					fullname: $('input[name=name]').val()
				}
				self._post('api/user', self._userRegistered, JSON.stringify(user));
			});
		},
		_userRegistered: function(user) {
			this.options.context.trigger('user-registered', user);
		},
		options: {
			context: null,
			template: 'components/user/register.html'
		}
	});
})(jQuery);
});