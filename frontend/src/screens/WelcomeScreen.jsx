import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import AppIntroSlider from 'react-native-app-intro-slider'
import LoginScreen from './LoginScreen'

const slideItems = [
    {
        key: 1,
        title: 'Slide 1',
        backgroundColor: '#444444'
    },
    {
        key: 2,
        title: 'Slide 2',
        backgroundColor: '#FFC60B'
    },
    {
        key: 3,
        title: 'Slide 3',
        backgroundColor: '#FF8B00'
    }
]

const WelcomeScreen = () => {

    const [showRealApp, setShowRealApp] = useState(false);


    const renderItems = ({ item }) => {
        return (
            <View style={{
                flex: 1,
                alignItems: 'center',
                justifyContent: 'center',
                backgroundColor: item.backgroundColor,
            }}>
                <Text>{item.title}</Text>
            </View>
        )
    }
    const onDone = () => {
        setShowRealApp(true)
    }
    const onSkip = () => {
        setShowRealApp(true)
    }

    return (
        <>
            {showRealApp ? 
                <LoginScreen /> :
                    <AppIntroSlider
                    data={slideItems}
                    renderItem={renderItems}
                    onDone={onDone}
                    onSkip={onSkip}
                    showSkipButton
                showPrevButton/>
                }
        </>
  )
}

export default WelcomeScreen

const styles = StyleSheet.create({})