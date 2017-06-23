package model.user;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;;

@Target( { FIELD, METHOD } )
@Retention( RUNTIME )
@Constraint( validatedBy = { UnUsedMail.Validator.class } )
public @interface UnUsedMail {
	String value() default "";

	String message() default "このメールアドレスは既に使われています。";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


	class Validator implements ConstraintValidator<UnUsedMail, String>{
		@Autowired
		private UserRepository userRepository;

		@Override
		public void initialize(UnUsedMail constraintAnnotation) {
		}

		@Override
		public boolean isValid(String target, ConstraintValidatorContext context) {
			if(target.isEmpty()){
				return true;
			}

			boolean valid = isUnUsed(target);

			return valid;
		}

		private boolean isUnUsed( String target )
        {
            boolean used = false;
            try{
                used = userRepository.isUsed(new UserMail(target));
                return !used;
            }catch( Exception e)
            {
                return !used;
            }
        }
	}

}
