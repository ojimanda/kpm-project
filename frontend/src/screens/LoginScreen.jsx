import { StyleSheet, Text, TextInput, View } from "react-native";
import React from "react";
import LongButton from "../components/LongButton";
import CustomInput from "../components/CustomInput";

const LoginScreen = () => {
	return (
		<View style={styles.parent}>
			<View style={styles.container}>
				<Text style={styles.title}>LOGIN</Text>
				<View style={styles.content}>
					<CustomInput
						placeholder={"email"}
						style={styles.input}
						placeholderTextColor="#FEFFDB"
					/>
					<CustomInput
						placeholder={"password"}
						secureTextEntry={true}
						style={styles.input}
						placeholderTextColor="#FEFFDB"
					/>
					<LongButton style={styles.btnLogin}>Login</LongButton>
					<View style={{ flexDirection: "row", alignItems: "center" }}>
						<View style={{ flex: 1, height: 1, backgroundColor: "#FEFFDB" }} />
						<View>
							<Text
								style={{ width: 50, textAlign: "center", color: "#FEFFDB" }}
							>
								OR
							</Text>
						</View>
						<View style={{ flex: 1, height: 1, backgroundColor: "#FEFFDB" }} />
					</View>
					<LongButton style={styles.btnSignUp}>Sign Up</LongButton>
				</View>
			</View>
		</View>
	);
};

export default LoginScreen;

const styles = StyleSheet.create({
	parent: {
		flex: 1,
		justifyContent: "center",
		alignItems: "center",
		backgroundColor: "#FEFFDB",
	},
	container: {
		width: "75%",
		height: 425,
		padding: 20,
		backgroundColor: "#444444",
		borderRadius: 10,
		alignItems: "center",
	},
	title: {
		fontSize: 28,
		fontWeight: "bold",
		color: "#FEFFDB",
	},
	content: {
		width: "100%",
		marginTop: 50,
	},
	btnLogin: {
		backgroundColor: "#FFC60B",
		marginVertical: 20,
	},
	btnSignUp: {
		backgroundColor: "#FEFFDB",
	},
	input: {
		color: "#FEFFDB",
	},
});
