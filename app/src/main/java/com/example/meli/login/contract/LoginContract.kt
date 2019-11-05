package com.example.meli.login.contract

interface LoginContract {
    interface Presenter {
        /**
         * Method to check input from email {@see TextInputEditText}
         *
         * @param email - input from email {@see TextInputEditText}
         */
        fun onEmailFilled(email: String)

        /**
         * Method to check input from password {@see TextInputEditText}
         *
         * @param password - input from password {@see TextInputEditText}
         */
        fun onPasswordFilled(password: String)

        /**
         * Method to handle enter button click
         *
         * @param email - input from email {@see TextInputEditText}
         * @param password - input from password {@see TextInputEditText}
         */
        fun onEnterButtonClicked(email: String, password: String)

        /**
         * Method to dispose variables
         */
        fun unregister()
    }

    interface Router {
        /**
         * Method to navigate to search screen
         */
        fun goToSearchScreen()

        /**
         * Method to dispose variables
         */
        fun unregister()
    }

    interface View {
        /**
         * Method to hide error message from email {@see TextInputLayout}
         */
        fun hideEmailFilledError()

        /**
         * Method to hide error message from password {@see TextInputLayout}
         */
        fun hidePasswordFilledError()

        /**
         * Method to show error message from email {@see TextInputLayout}
         */
        fun showEmailFilledError()

        /**
         * Method to show error message from password {@see TextInputLayout}
         */
        fun showPasswordFilledError()
    }
}