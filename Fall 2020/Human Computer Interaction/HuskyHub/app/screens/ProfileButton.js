import React from "react";
import Icon from 'react-native-vector-icons/Ionicons';
import { useNavigation } from '@react-navigation/native';
import {StyleSheet} from 'react-native';

import colors from '../config/colors';

export default function ProfileButton () {
    const navigation = useNavigation();
    return (
        <Icon.Button
            IconComponent={Icon.Person}
            iconSize={25}
            name="ios-person"
            backgroundColor={colors.black}
            style={styles.profile}
            onPress={() => navigation.navigate('Not Found')}
        />
    );
};

const styles = StyleSheet.create({
  profile: {
    paddingRight: 2,
  },
});
