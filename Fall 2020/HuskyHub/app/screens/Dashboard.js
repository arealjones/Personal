import React from 'react';
import { Image, ImageBackground, StyleSheet, View, Text, TextInput, TouchableOpacity, Button,} from 'react-native';

import colors from '../config/colors';


export default function Dashboard ({navigation}) {
      return (
        <View style={styles.container}>
          <Text style = {styles.logo}> My Dashboard </Text>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Events')}> My Events </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> My People </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> My Communities </Text>
          </TouchableOpacity>
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
    forgot:{
        color: colors.black,
        fontSize:13
    },
    husky: {
        flexShrink: 1,
        width: "30%",
        height: "20%",
        top: 15, 
        marginTop: 15,
     },
    inputText:{
        height:50,
        color: colors.black
    },
    inputView:{
        width:"80%",
        backgroundColor: colors.lightGrey,
        borderRadius:25,
        height:50,
        marginBottom:20,
        justifyContent:"center",
        padding:20
    },
    loginBtn:{
        width:"80%",
        backgroundColor: colors.brightRed,
        borderRadius:25,
        height:50,
        alignItems:"center",
        justifyContent:"center",
        marginTop:10,
        marginBottom:10
    },

    dashboardBtn:{
        width:"80%",
        backgroundColor: colors.brightRed,
        borderRadius:10,
        height:50,
        width: 300,
        alignItems:"center",
        justifyContent:"center",
        marginTop:10,
        marginBottom:10
    },

    signUpBtn: {
        width:"80%",
        backgroundColor: colors.brightRed,
        borderRadius:25,
        height:50,
        alignItems:"center",
        justifyContent:"center",
        marginTop:10,
        marginBottom:30
    },
    loginText:{
        fontWeight:"bold",
        color: colors.black
    },
    dashboardText:{
        fontWeight:"bold",
        fontSize: 25, 
        color: colors.black
    },
    logo:{
        fontWeight:"bold",
        fontSize:40,
        textAlign: 'center',
        color: colors.black,
        marginTop: 10,
        marginBottom:15
    },
    logoSub:{
        fontSize:20,
        color: colors.black,
        marginBottom:20,
    }
})
