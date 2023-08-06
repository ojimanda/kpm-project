import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'

const LongButton = ({children, style, styleButton}) => {
  return (
  <TouchableOpacity style={[styles.button, style]}>
          <Text style={[styles.textButton, styleButton]}>{children}</Text>
  </TouchableOpacity>
  )
}

export default LongButton

const styles = StyleSheet.create({
    button: {
        padding: 10,
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 10,
        marginTop: 15
    },
    textButton: {
        fontSize: 16,
    }
})