package my.sandbox.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public final class ConsoleScanner {

	public final static Scanner CONSOLE_SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

	private ConsoleScanner() {}
}
