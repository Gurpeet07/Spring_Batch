  $(document).ready(function() {
    $('#registration').bootstrapValidator({
        fields: {
        	customerName: {
                validators: {
                        stringLength: {
                        min: 2,
                        max:30,
                    },
                    regexp: {
                        regexp:'^[a-zA-Z0-9]*$',
                        message: 'Invalid Format'
                    },
                        notEmpty: {
                        message: 'Please supply customer name'
                    }
                }
            },
            customerId: {
                validators: {
                    regexp: {
                        regexp:'^[0-9]{1,10}',
                        message: 'Invalid Format'
                    },
                    notEmpty: {
                        message: 'Please supply customer code'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    regexp: {
                        regexp:'^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$',
                        message: 'Invalid Format'
                    }
                }
            },
            contactNumber: {
                validators: {
                	 stringLength: {
                    min: 10,
                    max:20,
                },
                    notEmpty: {
                        message: 'Please enter contact number'
                    },
                }
            },
            customerAddress: {
                validators: {
                     stringLength: {
                        max: 100,
                    },
                    notEmpty: {
                        message: 'Please enter customer address'
                    }
                }
            },
            pincode: {
                validators: {
                	stringLength: {
                	min:6,
                    max: 6,
            		},
                    notEmpty: {
                        message: 'Please supply your pin code'
                    },
                    regexp: {
                        regexp:'^[0-9]',
                        message: 'Invalid Format'
                    },
                    pinCode: {
                        country: 'IN',
                        message: 'Please supply a vaild pin code'
                    }
                }
            },
            }
        })
});

