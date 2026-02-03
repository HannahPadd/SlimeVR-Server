package dev.slimevr.desktop.platform.windows

import java.io.IOException

class InstallWindows {

	fun DoWindowsCheck() {
		CheckIfUSBDriversInstalled()
	}


	fun executeShellCommand(command: String): String {
		return try {
			val process = ProcessBuilder(*command.split(" ").toTypedArray())
				.redirectErrorStream(true)
				.start()
			process.inputStream.bufferedReader().readText().also {
				process.waitFor()
			}
		} catch (e: IOException) {
			"Error executing command: ${e.message}"
		}
	}

	fun CheckIfUSBDriversInstalled() {
		val installedDriversList = executeShellCommand("Get-WindowsDriver")
		println(installedDriversList)
	}

	fun InstallUSBDrivers() {

	}

	fun CheckIfSteamVRDriversInstalled() {

	}

	fun RegisterSteamDriver() {

	}
}
