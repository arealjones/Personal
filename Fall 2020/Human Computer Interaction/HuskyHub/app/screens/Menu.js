import React from 'react';
import { Image, ImageBackground, StyleSheet, View, Text, TextInput, TouchableOpacity, Button,} from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';


import colors from '../config/colors';


export default function Menu ({navigation}) {
      return (
        <ScrollView style = {{flex:1}} 
        contentContainerStyle = {styles.container} 
        scrollEnabled = {true}
        automaticallyAdjustContentInsets = {true}   >

          <Text style = {styles.logo}> Menu </Text>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Dashboard')}> Dashboard </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> People </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Communities </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Calendar </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Seattle Map </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Campus Map </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Messages </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Not Found')}> Settings </Text>
          </TouchableOpacity>
          <TouchableOpacity style = {styles.dashboardBtn}>
              <Text style = {styles.dashboardText} onPress = {() => navigation.navigate('Login')}> Logout </Text>
          </TouchableOpacity>
        </ScrollView>
      );
    }
  

const styles = StyleSheet.create({
    container: {
        flex: 1, 
        backgroundColor: colors.black,
        alignItems: 'center',
        justifyContent: 'center',
    },
    dashboardBtn:{
        width:"80%",
        backgroundColor: colors.darkGrey,
        borderRadius:10,
        height:50,
        width: 300,
        alignItems:"center",
        justifyContent:"center",
        marginTop:10,
        marginBottom:10
    },
    dashboardText:{
        fontWeight:"bold",
        fontSize: 25, 
        color: colors.white
    },
    logo:{
        fontWeight:"bold",
        fontSize:40,
        textAlign: 'center',
        color: colors.white,
        marginTop: 10,
        marginBottom:15
    }
})


