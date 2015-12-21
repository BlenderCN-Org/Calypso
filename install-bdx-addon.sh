#!/bin/bash

platform="$(uname)"

if [[ "$platform" == "Darwin" ]]; then
    ADDONS_DIR=/Users/$USER/Library/Application Support/Blender/2.76/scripts/addons
elif [[ "$platform" == "Linux" ]]; then
    ADDONS_DIR=$HOME/.config/blender/2.76/scripts/addons
fi

echo "linking $PWD/bdx to $ADDONS_DIR"
mkdir -p $ADDONS_DIR
ln -snf $PWD/bdx $ADDONS_DIR/
