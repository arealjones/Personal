import React, {useState} from 'react';
import {Image, ImageBackground, StyleSheet, View, Text, TextInput, TouchableOpacity, Button, Alert} from 'react-native';
import {Picker} from '@react-native-community/picker';

import colors from '../config/colors';
import { ScrollView } from 'react-native-gesture-handler';

export default function Signup ({navigation}) {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState(""); 
    const [selectedValue, setSelectedValue] = useState("Program");
    const signupAlert = () => Alert.alert("Congrats!", "You have successfully signed up for HuskyHub.", 
    [
      {text: "Continue to Dashboard", onPress: () => navigation.navigate('Dashboard')},
      {text: "Close"}
    ])
      return (
        <ScrollView style = {{flex:1}} 
        contentContainerStyle = {styles.container} 
        scrollEnabled = {true}
        automaticallyAdjustContentInsets = {true}   >
          
           
          <Text style={styles.logo}>Sign Up</Text>
          <Text style={styles.logoSub}>Enter your information below.</Text>
          <Text style={styles.headers}>Name</Text>
          <View style={styles.inputView} >
            <TextInput  
              style={styles.inputText}
              placeholder="Name..." 
              placeholderTextColor="#003f5c"
              onChangeText={text => setName({name:text})}/>
          </View>
          <Text style={styles.headers}>Email</Text>
          <View style={styles.inputView} >
            <TextInput  
              style={styles.inputText}
              placeholder="Email..." 
              placeholderTextColor="#003f5c"
              onChangeText={text => setEmail({email:text})}/>
          </View>
          <Text style={styles.headers}>Password</Text>
          <View style={styles.inputView} >
            <TextInput  
              secureTextEntry
              style={styles.inputText}
              placeholder="Password..." 
              placeholderTextColor="#003f5c"
              onChangeText={text => setPassword({password:text})}/>
          </View>
          <Text style={styles.headers}>Program</Text>
          <View style={styles.programPicker}>
            <Picker selectedValue={selectedValue} onValueChange={(itemValue, itemIndex) => setSelectedValue(itemValue)}>
              <Picker.Item label="Align Master of Science in Computer Science" value="Align Master of Science in Computer Science"/>
              <Picker.Item label="Master of Science in Computer Science" value="Master of Science in Computer Science"/>
              <Picker.Item label="Master of Education" value="Master of Education"/>
              <Picker.Item label="Master of Professional Studies in Analytics" value="Master of Professional Studies in Analytics"/>
              <Picker.Item label="Master of Science in Information Systems" value="Master of Science in Information Systems"/>
              <Picker.Item label="Master of Science in Project Management" value="Master of Science in Project Management"/>
              <Picker.Item label="Master of Science in Innovation" value="Master of Science in Innovation"/>
              <Picker.Item label="Master of Business Administration" value="Master of Business Administration"/>
              <Picker.Item label="Master of Science in Finance" value="Master of Science in Finance"/>
            </Picker>
          </View>
          <TouchableOpacity style={styles.loginBtn}>
            <Text style = {styles.loginText} onPress = {signupAlert}>SIGNUP</Text>
          </TouchableOpacity>

        </ScrollView>
      );
    }
  

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: colors.white,
        alignItems: 'center',
        justifyContent: 'center',
    },
    headers:{
      fontSize:20,
      marginBottom:"1%",
      color: colors.brightRed,
    },
    inputText:{
        height:50,
        color: colors.black,
        alignItems: 'center',
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
    loginText:{
        fontWeight:"bold",
        color: colors.black
    },
    logo:{
        fontWeight:"bold",
        fontSize:40,
        textAlign: 'center',
        color: colors.black,
        marginBottom:15,
    },
    logoSub:{
        fontSize:20,
        color: colors.black,
        marginBottom:25,
    },
    programPicker: {
      height: 50,
      width: "80%",
      marginBottom: 160,
    },
})

// Code pulled from here: https://github.com/Alhydra/React-Native-Login-Screen-Tutorial/blob/master/App.js
