import React from "react";
import Icon from 'react-native-vector-icons/Ionicons';
import { useNavigation } from '@react-navigation/native';
import {StyleSheet} from 'react-native';

import colors from '../config/colors';

export default function MenuButton () {
    const navigation = useNavigation();
    return (
        <Icon.Button
            IconComponent={Icon.Menu}
            iconSize={25}
            name="ios-menu"
            backgroundColor={colors.black}
            style={styles.menu}
            onPress={() => navigation.navigate('Menu')}
        />
    );
};

const styles = StyleSheet.create({
    menu: {
      paddingRight: 1
    },
  });
