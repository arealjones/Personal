import React, {useState} from 'react';
import { Image, ImageBackground, StyleSheet, View, Text, TextInput, TouchableOpacity, Button,} from 'react-native';

import colors from '../config/colors';

export default function LoginScreen ({navigation}) {
    const [email, setEmail] = useState(""); 
    const [password, setPassword] = useState(""); 
      return (
        <View style={styles.container}>
          <Image style={styles.husky} source={require('../assets/husky.png')}/>
          <Text style={styles.logo}>Welcome to HuskyHub</Text>
          <Text style={styles.logoSub}>Please Login</Text>
          <View style={styles.inputView} >
            <TextInput  
              style={styles.inputText}
              placeholder="Email..." 
              placeholderTextColor="#003f5c"
              onChangeText={text => setEmail({email:text})}/>
          </View>
          <View style={styles.inputView} >
            <TextInput  
              secureTextEntry
              style={styles.inputText}
              placeholder="Password..." 
              placeholderTextColor="#003f5c"
              onChangeText={text => setPassword({password:text})}/>
          </View>
          <TouchableOpacity onPress = {() => navigation.navigate('Not Found')}>
            <Text style={styles.forgot}>Forgot Password?</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.loginBtn} onPress = {() => navigation.navigate('Dashboard')}>
            <Text style = {styles.loginText}>LOGIN TO DASHBOARD</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.signUpBtn} onPress = {() => navigation.navigate('Signup')}>
            <Text style={styles.loginText}>SIGNUP</Text>
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


// Code pulled from here: https://github.com/Alhydra/React-Native-Login-Screen-Tutorial/blob/master/App.js


// export default LoginScreen;
