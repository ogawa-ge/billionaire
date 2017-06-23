package model.savings.goal;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;

import model.fixedcost.FixedCostRepository;
import model.income.IncomeRepository;

@Target( { TYPE, FIELD, ANNOTATION_TYPE, METHOD } )
@Retention( RUNTIME )
@Constraint( validatedBy = { OverAvailableAmount.Validator.class } )
public @interface OverAvailableAmount{
	String value() default "";

	String message() default "{hs.contract.validator.constraints.OverIncomeAmount.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    class Validator implements ConstraintValidator<OverAvailableAmount, SavingsGoal>
    {
		@Autowired
        private IncomeRepository incomeRepository;
		@Autowired
        private FixedCostRepository fixedCoxtRepository;

        @Override
        public void initialize( OverAvailableAmount constraintAnnotation )
        {
        }

        @Override
        public boolean isValid( SavingsGoal target, ConstraintValidatorContext context )
        {
            if( target.isEmpty() )
                return true;

            boolean valid = isNotOver( target );

            return valid;
        }

        private boolean isNotOver( SavingsGoal target )
        {
            boolean over = false;
            try{
            	Integer incomeAmount = incomeRepository.findAmount(target.userId());
            	Integer fixedCostTotalAmount = fixedCoxtRepository.findTotal(target.userId());

                over = (incomeAmount - fixedCostTotalAmount) < Integer.valueOf(target.savingsGoalAmount().value());
                return !over;

            }catch( Exception e)
            {
                return !over;
            }
        }
    }
}
