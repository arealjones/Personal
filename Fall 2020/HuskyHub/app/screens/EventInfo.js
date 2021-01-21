import colors from '../config/colors';
import React, { useState } from 'react';
import {StyleSheet,Text,View,TextInput,Button,TouchableHighlight,Alert,Image,FlatList,TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';
import { ScrollView } from 'react-native-gesture-handler';

export default function EventInfo({ route, navigation }) {

    const {key, timeRange, dateDay, dateMonth, organizer, typeOfEvent, association, engagementLevel, description} = route.params;

    return (
        <ScrollView style = {{flex:1}} 
        contentContainerStyle = {styles.container} 
        scrollEnabled = {true}
        automaticallyAdjustContentInsets = {true}   >
            <View style={styles.container}>
                <Text style={styles.headers}>Name</Text>
                <Text style={styles.subText}>{key}</Text>
                <Text style={styles.headers}>Event Association</Text>
                <Text style={styles.subText}>{association}</Text>
                <Text style={styles.headers}>Organizer</Text>
                <Text style={styles.subText}>{organizer}</Text>
                <Text style={styles.headers}>Date and Time</Text>
                <Text style={styles.subText}>{dateDay+" "+dateMonth+" ("+timeRange+")"}</Text>
                <Text style={styles.headers}>Type of Event</Text>
                <Text style={styles.subText}>{typeOfEvent}</Text>
                <Text style={styles.headers}>Level Of Engagement</Text>
                <Text style={styles.subText}>{engagementLevel}</Text>
                <Text style={styles.headers}>About</Text>
                <Text style={styles.subText}>{description}</Text>
                <View style={styles.rsvpButtonRow}>
                    <TouchableOpacity style={styles.rsvpButton} onPress = {() => navigation.navigate('Not Found')}>
                        <Text style={styles.buttonText}>RSVP</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </ScrollView>
    );
 }

const styles = StyleSheet.create({
    container:{
        padding:10,
        marginTop:"3%",
        marginLeft:"3%",
    },
    buttonText:{
        fontSize:20,
        fontWeight:"bold",
        color: colors.white,
    },
    headers:{
        fontSize:35,
        marginBottom:"1%",
        color: colors.brightRed,
    },
    rsvpButton:{
        width:"80%",
        backgroundColor: colors.brightRed,
        borderRadius:25,
        height:50,
        alignItems:"center",
        justifyContent:"center",
        marginTop:"1%",
        marginBottom:"1%",
    },
    rsvpButtonRow:{
        flexDirection: "row",
        alignItems: "center",
        justifyContent: "center",
      },
    subText:{
        fontSize:20,
        marginBottom:"4%",
        color: colors.darkGrey,
    },
    userName:{
        fontSize:16,
        color:colors.black,
        marginBottom:"1%",
    },
});
