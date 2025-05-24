/**
 * Toastr Notifications Utility
 * Provides functions to display Toastr notifications with customizable messages
 */

// Configure Toastr options
toastr.options = {
    closeButton: true,
    progressBar: true,
    positionClass: 'toast-top-right',
    timeOut: 3000,
    preventDuplicates: true
};

/**
 * Display a success notification
 * @param {string} message - The message to display
 * @param {string} [title] - Optional title for the notification
 */
function showSuccess(message, title = 'Success') {
    toastr.success(message, title);
}

/**
 * Display an error notification
 * @param {string} message - The message to display
 * @param {string} [title] - Optional title for the notification
 */
function showError(message, title = 'Error') {
    toastr.error(message, title);
}

/**
 * Display an info notification
 * @param {string} message - The message to display
 * @param {string} [title] - Optional title for the notification
 */
function showInfo(message, title = 'Info') {
    toastr.info(message, title);
}

/**
 * Display a warning notification
 * @param {string} message - The message to display
 * @param {string} [title] - Optional title for the notification
 */
function showWarning(message, title = 'Warning') {
    toastr.warning(message, title);
}