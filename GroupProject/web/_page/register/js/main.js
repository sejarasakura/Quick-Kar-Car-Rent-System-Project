(function($) {
$(document).ready(function() {

    
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
    

    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
});
  $('#meal_preference').parent().append('<ul class="list-item" id="newmeal_preference" name="meal_preference"></ul>');
  $('#meal_preference option').each(function(){
      $('#newmeal_preference').append('<li value="' + $(this).val() + '">'+$(this).text()+'</li>');
  });
  $('#meal_preference').remove();
  $('#newmeal_preference').attr('id', 'meal_preference');
  $('#meal_preference li').first().addClass('init');
  $("#meal_preference").on("click", ".init", function() {
      $(this).closest("#meal_preference").children('li:not(.init)').toggle();
  });
  
  var allOptions = $("#meal_preference").children('li:not(.init)');
  $("#meal_preference").on("click", "li:not(.init)", function() {
      allOptions.removeClass('selected');
      $(this).addClass('selected');
      $("#meal_preference").children('.init').html($(this).html());
      allOptions.toggle();
  });

  var marginSlider = document.getElementById('slider-margin');
  if (marginSlider != undefined) {
      noUiSlider.create(marginSlider, {
            start: [500],
            step: 10,
            connect: [true, false],
            tooltips: [true],
            range: {
                'min': 0,
                'max': 1000
            },
            format: wNumb({
                decimals: 0,
                thousand: ',',
                prefix: '$ ',
            })
    });
  }
  $('#reset').on('click', function(){
      $('#register-form').reset();
  });

  $('#register-form').validate({
                    rules: {
                        first_name: {
                            required: true,
                            regex: regex_list.Validate.name
                        },
                        last_name: {
                            required: true,
                            regex: regex_list.Validate.name
                        },
                        phone_num: {
                            required: true,
                            regex: regex_list.Validate.phone_num
                        },
                        ic_num: {
                            required: true,
                            regex: regex_list.Validate.ic_num
                        },
                        card_num: {
                            regex: regex_list.Validate.card_num
                        },
                        password: {
                            required: true,
                            minlength: 8,
                            regex: regex_list.Validate.password
                        },
                        confirm_password: {
                            required: true,
                            minlength: 8,
                            equalTo: "#password",
                            regex: regex_list.Validate.password
                        },
                        license: {
                            required: true,
                            regex: regex_list.Validate.license
                        },
                        payment_method: {
                            required: true,
                            regex: regex_list.Validate.enum
                        }
                    },
                    message:{
                        confirm_password: {
                            equalTo: "The password enter is not match, please tray agian"
                        }
                    },
                    errorPlacement: function(label, element) {
                        label.addClass('text-danger');
                        label.insertAfter(element);
                    },
                    wrapper: 'span'
                });

})(jQuery);