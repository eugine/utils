#!/bin/bash

PHOTO_SRC_DIR='/media/data/Photo Library'
PHOTO_DST_DIR='/media/eugene/WD_Passport/Photo_Library'

# Shotwell home dir
SW_SRC_DIR='/home/eugene/.local/share/shotwell'
SW_DST_DIR='/media/eugene/WD_Passport/back_up/shotwell'

echo 'Synchronizing Photo library'
#sudo rsync --delete -va $PHOTO_SRC_DIR $PHOTO_DST_DIR

echo 'Synchronizing Shotwell database'
sudo rsync --delete -va $SW_SRC_DIR $SW_DST_DIR
 
