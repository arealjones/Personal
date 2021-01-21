import { setStatusBarBackgroundColor, StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer, StackActions } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import LoginScreen from './app/screens/LoginScreen';
import Dashboard from './app/screens/Dashboard';
import Signup from './app/screens/Signup';
import colors from './app/config/colors';
import NotFoundScreen from './app/screens/NotFoundScreen';
import Menu from './app/screens/Menu';
import Icon from 'react-native-vector-icons/Ionicons';
import MenuButton from './app/screens/MenuButton';
import ProfileButton from './app/screens/ProfileButton';
import EventsScreen from './app/screens/EventsScreen';
import EventInfo from './app/screens/EventInfo';
import { color } from 'react-native-reanimated';


export default function App() {

  const Stack = createStackNavigator();

  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName = "Login">
      <Stack.Screen name="Login" component={LoginScreen} options = {{title: "", headerStyle: {backgroundColor: colors.brightRed}}}/>
      <Stack.Screen name = "Dashboard" component = {Dashboard} 
        options = {{title: "HuskyHub", 
        headerRight: () => (<View style={{flexDirection:"row",padding:4}}><View style={{marginRight:2}}><ProfileButton/></View><MenuButton/></View>), 
        headerStyle: {backgroundColor: colors.brightRed}}}/>
      <Stack.Screen name ="Signup" component = {Signup} options = {{title: "", headerStyle: {backgroundColor: colors.brightRed}, headerBackTitleStyle: colors.black}}/>
      <Stack.Screen name = "Not Found" component = {NotFoundScreen} options = {{title: "", headerStyle: {backgroundColor: colors.brightRed}}}/>
      <Stack.Screen name = "Menu" component = {Menu} options = {{title: "", headerStyle: {backgroundColor: colors.brightRed}}}/>
      <Stack.Screen name = "Events" component = {EventsScreen} 
        options = {{title: "", 
        headerRight: () => (<View style={{flexDirection:"row",padding:4}}><View style={{marginRight:2}}><ProfileButton/></View><MenuButton/></View>),
        headerStyle: {backgroundColor: colors.brightRed}}}/>
      <Stack.Screen name = "EventInfo" component = {EventInfo} 
        options = {{title: "", 
        headerRight: () => (<View style={{flexDirection:"row",padding:4}}><View style={{marginRight:2}}><ProfileButton/></View><MenuButton/></View>),
        headerStyle: {backgroundColor: colors.brightRed}}}/>
      </Stack.Navigator>
    </NavigationContainer>
    )
}
