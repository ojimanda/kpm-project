import { StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'

const CustomInput = ({placeholder, secureTextEntry = false, style, placeholderTextColor="#000"}) => {
    return (
        <>
            <TextInput placeholderTextColor={placeholderTextColor} secureTextEntry={secureTextEntry} style={[styles.input, style]} placeholder={placeholder} />
        </>

  )
}

export default CustomInput

const styles = StyleSheet.create({
    input: {
        padding: 20
    }
})