package com.insignia.stringValidator;

import com.insignia.customExceptions.InvalidInputParametersException;
import com.insignia.stringConstant.ValidatorConstants;

public class StringValidation {

	public static void ValidateUserId(String userId, int length) throws InvalidInputParametersException {

		if (userId == null || userId == "" || userId.isBlank()) {
			throw new InvalidInputParametersException(ValidatorConstants.validUserIdErrorCode,
					ValidatorConstants.validUserId);

		} else if (userId.length() > length) {
			throw new InvalidInputParametersException(ValidatorConstants.validUserIdLengthErrorCode,
					ValidatorConstants.validUserIdLength);

		} else if (!userId.matches(ValidatorConstants.regularExpression)) {
			throw new InvalidInputParametersException(ValidatorConstants.validUserIDInvalidCharactersErrorCode,
					ValidatorConstants.validUserIdExpression);

		}

	}
	public static void ValidatePassword(String password, int length) throws InvalidInputParametersException {

		if (password == null || password == "" || password.isBlank()) {
			throw new InvalidInputParametersException(ValidatorConstants.validPasswordErrorCode,
					ValidatorConstants.validPassword);

		} else if (password.length() > length) {
			throw new InvalidInputParametersException(ValidatorConstants.validPasswordLengthErrorCode,
					ValidatorConstants.validPasswordLength);

		} else if (!password.matches(ValidatorConstants.regularExpression)) {
			throw new InvalidInputParametersException(ValidatorConstants.validPasswordInvalidCharactersErrorCode,
					ValidatorConstants.validPasswordExpression);

		}

	}

	public static void ValidateApplicationId(String applicationId, int length) throws InvalidInputParametersException {

		if (applicationId == null || applicationId == "" || applicationId.isBlank()) {
			throw new InvalidInputParametersException(ValidatorConstants.validApplicationIdErrorCode,
					ValidatorConstants.validApplicationId);

		} else if (applicationId.length() > length) {
			throw new InvalidInputParametersException(ValidatorConstants.validApplicationIdLengthErrorCode,
					ValidatorConstants.validApplicationIdLength);

		} else if (!applicationId.matches(ValidatorConstants.regularExpression)) {
			throw new InvalidInputParametersException(ValidatorConstants.validApplicationIdInvalidCharactersErrorCode,
					ValidatorConstants.validApplicationIdExpression);

		}

	}

	public static void ValidateTenantId(String tenantId, int length) throws InvalidInputParametersException {

		if (tenantId == null || tenantId == "" || tenantId.isBlank()) {
			throw new InvalidInputParametersException(ValidatorConstants.validTenantIdErrorCode,
					ValidatorConstants.validTenantId);

		} else if (tenantId.length() > length) {
			throw new InvalidInputParametersException(ValidatorConstants.validTenantIdLengthErrorCode,
					ValidatorConstants.validTenantIdLength);

		} else if (!tenantId.matches(ValidatorConstants.regularExpression)) {
			throw new InvalidInputParametersException(ValidatorConstants.validTenantIdInvalidCharactersErrorCode,
					ValidatorConstants.validTenantIdExpression);
		}

	}


}
