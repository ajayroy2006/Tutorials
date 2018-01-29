interface Validator {
    public abstract boolean isValid();
}

class PersonalLoanValidator implements Validator {
    @Override
    public boolean isValid() {
        //Validation logic.
    }
}

class VehicleLoanValidator implements Validator {
    @Override
    public boolean isValid() {
        //Validation logic.
    }
}

class LoanApprovalHandler {
    public void approveLoan(Validator validator) {
        if (validator.isValid()) {
            //Process the loan.
        }
    }
}
