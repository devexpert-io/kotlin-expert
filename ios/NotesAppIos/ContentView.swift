//
//  ContentView.swift
//  NotesAppIos
//
//  Created by Antonio Leiva Gordillo on 11/7/23.
//

import SwiftUI
import common

struct ContentView: View {
    var body: some View {
        Text(GetPlatformNameKt.getPlatformName())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
