// Toggle to show Sign Up form
document.getElementById("showSignup").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("loginBox").classList.add("hidden");
  document.getElementById("signupBox").classList.remove("hidden");
});

// Toggle to show Login form
document.getElementById("showLogin").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

// Toggle to show Forgot Password form
document.getElementById("showForgot").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("loginBox").classList.add("hidden");
  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("forgotBox").classList.remove("hidden");
});

// Back to Login from Forgot Password
document.getElementById("backToLogin").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("forgotBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

// Handle Sign Up form submission
document.getElementById("signupForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const username = document.querySelector("#signupForm input[type='text']").value.trim();
  const email = document.querySelector("#signupForm input[type='email']").value.trim();
  const password = document.querySelectorAll("#signupForm input[type='password']")[0].value;
  const confirmPassword = document.querySelectorAll("#signupForm input[type='password']")[1].value;

  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

  if (!passwordRegex.test(password)) {
    alert(
      "Password must be at least 8 characters long and include:\n• Uppercase letter\n• Lowercase letter\n• Number\n• Special character."
    );
    return;
  }

  if (password !== confirmPassword) {
    alert("Passwords do not match.");
    return;
  }

  // If all is valid
  alert("Registered successfully! You can now log in.");

  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

// Send OTP for Sign Up mobile verification
function sendSignupOTP() {
  const mobile = document.getElementById("signupMobile").value;
  if (mobile.length === 10) {
    alert("OTP sent to mobile number " + mobile);
    document.getElementById("signupOtpBox").classList.remove("hidden");
  } else {
    alert("Enter valid 10-digit mobile number");
  }
}

// Send OTP for Forgot Password mobile verification
function sendForgotOTP() {
  const mobile = document.getElementById("forgotMobile").value;
  if (mobile.length === 10) {
    alert("OTP sent to mobile number " + mobile);
    document.getElementById("forgotOtpBox").classList.remove("hidden");
  } else {
    alert("Enter valid 10-digit mobile number");
  }
}

// Toggle password visibility in login form
const togglePassword = document.getElementById("togglePassword");
const passwordField = document.getElementById("password");

// Check if elements exist before adding event listener (to avoid errors)
if (togglePassword && passwordField) {
  togglePassword.addEventListener("click", function () {
    if (passwordField.type === "password") {
      passwordField.type = "text";
      togglePassword.classList.remove("bi-eye-slash");
      togglePassword.classList.add("bi-eye");
    } else {
      passwordField.type = "password";
      togglePassword.classList.remove("bi-eye");
      togglePassword.classList.add("bi-eye-slash");
    }
  });
}

/*
// Commented out unused or redundant lines below:

// document.querySelectorAll("#signupForm input[type='password']")[0].value; -- used above, so kept active
// document.querySelectorAll("#signupForm input[type='password']")[1].value; -- used above, so kept active

// If you have any other lines you think are unused, please share.

// You can also modularize these OTP sending functions if you want.

// The above code assumes elements with IDs:
// showSignup, showLogin, showForgot, backToLogin, loginBox, signupBox, forgotBox,
// signupForm, signupMobile, signupOtpBox, forgotMobile, forgotOtpBox, togglePassword, password
*/
