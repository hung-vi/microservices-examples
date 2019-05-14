package com.vnext.projekt.common.utils;

import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class StringCaseUtils
{
	/**
	 * Convert snake case string to camel case string
	 * Example: aaa_bbb_ccc -> aaaBbbCcc
	 * @param _snakeCase snake case string
	 * @return camel case string
	 */
	public static String snakeCaseToCamelCase(@NonNull String _snakeCase)
	{
		String[] words = StringUtils.split(_snakeCase, '_');

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (i > 0) {
				word = StringUtils.capitalize(word);
			}

			words[i] = word;
		}

		return StringUtils.join(words);
	}

	/**
	 * Convert camel case string to snake case string
	 * Example: aaaBbbCcc -> aaa_bbb_ccc
	 * @param _camelCase camel case string
	 * @return snake case string
	 */
	public static String camelCaseToSnakeCase(@NonNull String _camelCase)
	{
		String[] words = StringUtils.splitByCharacterTypeCamelCase(_camelCase);

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (i > 0) {
				word = StringUtils.uncapitalize(word);
			}

			words[i] = word;
		}

		return StringUtils.join(words, '_');
	}
}
