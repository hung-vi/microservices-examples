package com.vnext.projekt.common.utils;

import com.vnext.projekt.common.utils.StringCaseUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCaseUtilsTests
{
	@Test
	public void testSnakeCaseToCamelCase()
	{
		assertThat(StringCaseUtils.snakeCaseToCamelCase("aaa")).isEqualTo("aaa");
		assertThat(StringCaseUtils.snakeCaseToCamelCase("aaa_bbb_ccc")).isEqualTo("aaaBbbCcc");
		assertThat(StringCaseUtils.snakeCaseToCamelCase("aaa_")).isEqualTo("aaa");
		assertThat(StringCaseUtils.snakeCaseToCamelCase("__aaa__")).isEqualTo("aaa");
		assertThat(StringCaseUtils.snakeCaseToCamelCase("__aaa__bbb__ccc__")).isEqualTo("aaaBbbCcc");
		assertThat(StringCaseUtils.snakeCaseToCamelCase("AAA_BBB_CCC")).isEqualTo("AAABBBCCC");
	}

	@Test
	public void testCamelCaseToSnakeCase()
	{
		assertThat(StringCaseUtils.camelCaseToSnakeCase("aaa")).isEqualTo("aaa");
		assertThat(StringCaseUtils.camelCaseToSnakeCase("aaaBbbCcc")).isEqualTo("aaa_bbb_ccc");
		assertThat(StringCaseUtils.camelCaseToSnakeCase("aaaBBbCCc")).isEqualTo("aaa_b_bb_c_cc");
		assertThat(StringCaseUtils.camelCaseToSnakeCase("AAABBBCCC")).isEqualTo("AAABBBCCC");
	}
}