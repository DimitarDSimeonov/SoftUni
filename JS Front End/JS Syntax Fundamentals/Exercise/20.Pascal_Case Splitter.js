function pascalCaseSplitter(text){
    let output = text.split(/(?=[A-Z])/);

    console.log (output.join(", "));
}

pascalCaseSplitter('SplitMeIfYouCanHaHaYouCantOrYouCan');