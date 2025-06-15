// Navigation Toggles
document.getElementById("showSignup").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("loginBox").classList.add("hidden");
  document.getElementById("signupBox").classList.remove("hidden");
});

document.getElementById("showLogin").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

document.getElementById("showForgot").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("loginBox").classList.add("hidden");
  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("forgotBox").classList.remove("hidden");
});

document.getElementById("backToLogin").addEventListener("click", function (e) {
  e.preventDefault();
  document.getElementById("forgotBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

// Signup Submit Handler
document.getElementById("signupForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const username = document.getElementById("signupUsername").value.trim();
  const email = document.getElementById("signupEmail").value.trim();
  const mobile = document.getElementById("signupMobile").value.trim();
  const otp = document.getElementById("signupOtp").value.trim();
  const password = document.getElementById("signupPassword").value;
  const confirmPassword = document.getElementById("signupConfirmPassword").value;

  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;

  if (!passwordRegex.test(password)) {
    alert("Password must include:\n• Uppercase\n• Lowercase\n• Number\n• Special character\n• At least 8 characters");
    return;
  }

  if (password !== confirmPassword) {
    alert("Passwords do not match.");
    return;
  }

  if (mobile.length !== 10 || !/^\d+$/.test(mobile)) {
    alert("Please enter a valid 10-digit mobile number.");
    return;
  }

  if (otp.length === 0) {
    alert("Please enter the OTP sent to your mobile.");
    return;
  }

  const payload = { username, email, mobile, otp, password };
  console.log("Submitting Registration:", payload);
  alert("Registered successfully!");

  document.getElementById("signupBox").classList.add("hidden");
  document.getElementById("loginBox").classList.remove("hidden");
});

// OTP functions
function sendSignupOTP() {
  const mobile = document.getElementById("signupMobile").value.trim();
  if (mobile.length === 10 && /^\d+$/.test(mobile)) {
    alert("OTP sent to " + mobile);
    document.getElementById("signupOtpBox").classList.remove("hidden");
  } else {
    alert("Enter valid 10-digit mobile number");
  }
}

function sendForgotOTP() {
  const mobile = document.getElementById("forgotMobile").value.trim();
  if (mobile.length === 10 && /^\d+$/.test(mobile)) {
    alert("OTP sent to " + mobile);
    document.getElementById("forgotOtpBox").classList.remove("hidden");
  } else {
    alert("Enter valid 10-digit mobile number");
  }
}
