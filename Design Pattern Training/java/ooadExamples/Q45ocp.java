//Suppose you are writing a module to approve personal loans and 
//before doing that you want to validate the personal information.
//Later on, its required to approve vehicle loans, consumer goods loans and what not. 
class LoanApprovalHandler {
    public void approvePersonalLoan(PersonalLoanValidator validator) {
        if (validator.isValid()) {
            //Process the loan.
        }
    }
    public void approveVehicleLoan(VehicleLoanValidator validator) {
        if (validator.isValid()) {
            //Process the loan.
        }
    }
    // Methods for approving other loans.
}

class PersonalLoanValidator {
    public boolean isValid() {
        //Validation logic
    }
}

class VehicleLoanValidator {
    public boolean isValid() {
        //Validation logic
    }
}
