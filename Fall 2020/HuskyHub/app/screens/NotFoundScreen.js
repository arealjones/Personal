import React from 'react';
import { Image, View, StyleSheet, Text, SafeAreaView, BackHandler } from 'react-native';

import colors from '../config/colors';

function NotFoundScreen(props) {
    return (
        <View style={styles.container}>
            <Text style={styles.h1}> Whoops - this page hasn't been built yet! </Text>
            <Text style={styles.h2}> We're working on it...</Text>
            <Text style={styles.h2}> Right now our staff is taking a break</Text>
            <Image 
                source={require('../assets/puppies.jpg')} 
                style={styles.puppies}>
            </Image>

        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: colors.white,
        alignItems: 'center',
        justifyContent: 'center',
    },
    h1: {
        fontSize: 22,
        fontWeight: "bold",
        textAlign: "center",
        paddingBottom: 20,
        paddingTop: 10
    },
    h2: {
        fontSize: 18,
        fontStyle: 'italic',
        paddingBottom: 10,
        textAlign: "center",
    },
    // menuBar: {
    //     backgroundColor: colors.brightRed,
    //     width: "100%",
    //     height: 50,        
    // },
    puppies: {
        width: 600,
        height: 400,
        alignContent: 'center',
        resizeMode: 'cover',
    },
})

export default NotFoundScreen;
