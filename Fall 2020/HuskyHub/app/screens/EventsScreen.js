import colors from '../config/colors';
import React, { useState } from 'react';
import {StyleSheet,Text,View,TextInput,Button,TouchableHighlight,Alert,Image,FlatList,TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/Ionicons';
import { ScrollView } from 'react-native-gesture-handler';

export default function EventsScreen({navigation}) {

  const events = [
    {
      key:"Coffee and Resumes",
      timeRange: "11:00-11:30am (PST)",
      dateDay: "10",
      dateMonth: "Oct",
      organizer: "Jane Doe", 
      typeOfEvent: "Virtual",
      association: "Independent Student Interest Group", 
      engagementLevel: "Active", 
      favourited: false,
      favouriteIconColor: colors.black,
      description:"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}, 
     { 
      key: "Coffee Social",
      timeRange: "10:00-10:30am (PST)",
      dateDay: "12",
      dateMonth: "Oct",
      organizer: "Women in Tech", 
      typeOfEvent: "Virtual",
      association: "Student Interest Group", 
      engagementLevel: "Passive",  
      favourited: false, 
      favouriteIconColor: colors.black,
      description:"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}, 
    {
      key:"Learn Flutter",
      timeRange: "5:00-6:45pm (PST)",
      dateDay: "30",
      dateMonth: "Oct",
      organizer: "Developers Student Club", 
      typeOfEvent: "Virtual",
      association: "Student Interest Group", 
      engagementLevel: "Active",  
      favourited: false, 
      favouriteIconColor: colors.black,
      description:"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."}
    ]

  const[allEvents, setAllEvents] = useState(events);


  const favoriteEvents = (key) => {
    const keyIndex = events.findIndex(obj => obj.key === key);
    const eventsToUpdate = allEvents;
    const update = eventsToUpdate.map((item) => {
      if (item.key === key) {
        if (item.favourited === true) {
          item.favourited = false;
          item.favouriteIconColor = colors.black;
        } else {
          item.favourited = true;
          item.favouriteIconColor = colors.brightRed;
        }
      } 
      return item;
    });
    setAllEvents(update);
  }

  const searchUser = (textToSearch) => {
    setAllEvents(events.filter(i=>i.key.includes(textToSearch)));
  };

   return (
       <FlatList 
         enableEmptySections={true}
         style={styles.eventList}
         data={allEvents}
         extraData={allEvents}
         keyExtractor= {(item) => {
           return item.key;
         }}
         renderItem={({item}) => {
           return (
               <View style={styles.eventBox}>
                 <View style={styles.eventContent}>
                   <View style={styles.iconRow}>
                     <TouchableOpacity 
                      onPress = {() => { navigation.navigate('EventInfo', {
                        key: item.key,
                        timeRange: item.timeRange,
                        dateDay: item.dateDay,
                        dateMonth: item.dateMonth,
                        organizer: item.organizer,
                        typeOfEvent: item.typeOfEvent,
                        association: item.association,
                        engagementLevel: item.engagementLevel,
                        description: item.description
                        });
                      }}>
                      <Text  style={styles.userName}>{item.key.toString()}</Text>
                     </TouchableOpacity>
                     <View style={styles.dateBox}>
                       <Text style={styles.dateBoxDay}>{item.dateDay}</Text>
                       <Text style={styles.dateBoxMonth}>{item.dateMonth}</Text>
                     </View>
                   </View>
                   <View style={styles.eventInfo}>
                     <Text  style={styles.description}>{item.organizer.toString()}</Text>
                     <Text  style={styles.description}>{item.timeRange}</Text>
                     </View>
                   <Text  style={styles.description}>{item.description.toString()}</Text>
                   <View style={styles.favouriteAndArrow}>
                    <TouchableOpacity>
                      <Icon.Button IconComponent={Icon.Heart} iconSize={25} name="ios-heart"
                        backgroundColor={item.favouriteIconColor}
                        style={styles.favouriteIcon}
                        onPress={() => {favoriteEvents(item.key)}}
                      />
                    </TouchableOpacity>
                    <TouchableOpacity 
                      onPress = {() => { navigation.navigate('EventInfo', {
                        key: item.key,
                        timeRange: item.timeRange,
                        dateDay: item.dateDay,
                        dateMonth: item.dateMonth,
                        organizer: item.organizer,
                        typeOfEvent: item.typeOfEvent,
                        association: item.association,
                        engagementLevel: item.engagementLevel,
                        description: item.description
                        });
                      }}>
                      <Image style={styles.infoArrow} source={require('../assets/right-arrow.png')}/>
                    </TouchableOpacity>
                   </View>
                 </View>
               </View>
           )
         }}
         ListHeaderComponent = {
           <View style = {styles.container}>
          <View style={styles.container}>
          <View style={styles.iconRow}>
             <View style={styles.inputView} >
                <TextInput  
                  style={styles.inputText}
                  placeholder="Search..." 
                  placeholderTextColor={colors.black}
                  onChangeText={text => {searchUser(text)}}/>
                <TouchableOpacity>
                  <Image style={styles.searchIcon} source={require('../assets/search.png')}/>
                </TouchableOpacity>
             </View>
             <View style={styles.filterAddIcons}>
                <TouchableOpacity onPress = {() => navigation.navigate('Not Found')}>
                  <Image style={styles.filterIcon} source={require('../assets/filter.png')}/>
                </TouchableOpacity>
                <TouchableOpacity onPress = {() => navigation.navigate('Not Found')}>
                  <Image style={styles.addIcon} source={require('../assets/add.png')}/>
                </TouchableOpacity>
             </View>
          </View>
          <View style={styles.eventButtonRow}>
             <TouchableOpacity style={styles.eventsButton} onPress = {() => navigation.navigate('Not Found')}>
               <Text style = {styles.eventButtonText}>ALL EVENTS</Text>
             </TouchableOpacity>
             <TouchableOpacity style={styles.eventsButton} onPress = {() => navigation.navigate('Not Found')}>
               <Text style = {styles.eventButtonText}>MY EVENTS</Text>
             </TouchableOpacity>
          </View>
          </View>
          </View>
         }
         />  
      );
 }

const styles = StyleSheet.create({
  addButton: {
    marginTop:"1%",
  },
  addIcon: {
    width: 25,
    height: 25,
  },
  infoArrow: {
    width: 25,
    height: 25,
    marginLeft: "85%",
  },
  dateBox:{
    backgroundColor: colors.brightRed,
    padding: 15,
    borderRadius:20,
    position: "absolute",
    alignItems: "center",
    top: "1%",
    left:"85%",
  },
  dateBoxDay:{
    fontSize: 20,
    color: colors.white,
  },
  dateBoxMonth:{
    fontSize: 10,
    color: colors.white,
  },
  description:{
    fontSize:15,
    color: "#646464",
    marginBottom: 5,
  },
  eventList:{
    marginTop:"1%",
    marginLeft:"2%",
    marginRight: "2%",
  },
  eventBox: {
    padding:10,
    marginBottom:"1%",
    flexDirection: 'row',
  },
  eventButtonRow:{
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
  },
  eventButtonText:{
    fontWeight:"bold",
    color: colors.white
  },
  eventDate:{
    flexDirection: 'column',
  },
  eventDay:{
    fontSize:50,
    color: "#0099FF",
    fontWeight: "600",
  },
  eventInfo: {
    marginBottom:"4%",
  },
  eventMonth:{
    fontSize:16,
    color: "#0099FF",
    fontWeight: "600",
  },
  eventContent: {
    flex:1,
    flexDirection: 'column',
    alignItems: 'flex-start',
    backgroundColor: '#FFFFFF',
    padding:10,
    borderRadius:10,
  },
  eventTime:{
    fontSize:18,
    color:"#151515",
  },
  eventsButton: {
    width:"40%",
    backgroundColor: colors.brightRed,
    borderRadius:25,
    height:40,
    alignItems:"center",
    justifyContent:"center",
    marginLeft: "2%",
  },
  favouriteAndArrow:{
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
  },
  favouriteIcon: {
    paddingRight: .5,
    marginTop: "2%",
  },
  filterAddIcons: {
    marginLeft: "3%",
    justifyContent:"space-between",
    flexDirection: "row",
  },
  filterIcon: {
    width: 25,
    height: 25,
    marginRight: "4%",
  },
  iconRow:{
    flexDirection: "row",
    alignItems: "center",
  },
  inputText:{
    color: colors.black,
  },
  inputView:{
    width:"75%",
    backgroundColor: "#DCDCDC",
    borderRadius:25,
    height:60,
    marginLeft: "2%",
    marginTop: "5%",
    marginBottom:"5%",
    justifyContent:"space-between",
    padding:20,
    flexDirection: "row",
    alignItems: "center",
  },  
  searchIcon: {
    width: 25,
    height: 25,
  },
  userName:{
    fontSize:20,
    color:"#151515",
    marginBottom:"4%",
    textDecorationLine: 'underline',
  },
});
