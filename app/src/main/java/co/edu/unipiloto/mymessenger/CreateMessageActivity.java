package co.edu.unipiloto.mymessenger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CreateMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    public ArrayList<String> histo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        Intent intent = getIntent();
        ArrayList<String> chat = intent.getStringArrayListExtra(EXTRA_MESSAGE);
        if (chat != null) {
            histo = chat;
        }
        //String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        TextView messageView = (TextView) findViewById(R.id.chat);
        //messageView.setText(messageText);
        String chatHistory = "";
            for (String message : histo) {
                chatHistory += message + "\n";
            }
        messageView.setText(chatHistory);




    }

    public void onSendMessage(View view){
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        histo.add("     "+ "Propietario : " + messageText);
        Intent intent = new Intent(this,RecieveMessageActivity.class);
        //intent.putExtra(RecieveMessageActivity.EXTRA_MESSAGE,messageText);
        intent.putStringArrayListExtra(RecieveMessageActivity.EXTRA_MESSAGE,histo);
        startActivity(intent);
    }

    public String storeHistory(String message){
        histo.add(message);
        return histo.toString();

    }
}