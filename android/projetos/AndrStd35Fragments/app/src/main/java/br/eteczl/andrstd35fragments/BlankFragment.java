package br.eteczl.andrstd35fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    public static final String BLANK_ACTIVITY = "BLANK_FRAGMENT";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PARAMETRO_DE_INICIALIZACAO_1 = "paramInit1";
    private static final String PARAMETRO_DE_INICIALIZACAO_2 = "paramInit2";

    // TODO: Rename and change types of parameters
    private String parametroDeInstancia1DoFragmento;
    private String parametroDeInstancia2DoFragmento;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Este metodo roda quando o fragment he criado
     * Ou seja, quando vc da new na classe do Fragment
     * Ou seja, qdo vc faz new  BlankFragment()
     *
     * Perceba que o contrutor nao recebe parametros
     * mas esse metodo aqui recebe
     *
     * @param paramInit1 Parameter 1.
     * @param paramInit2 Parameter 2.
     * @return Uma nova instancia de BlankFragment
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String paramInit1, String paramInit2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(BlankFragment.PARAMETRO_DE_INICIALIZACAO_1, paramInit1);
        args.putString(BlankFragment.PARAMETRO_DE_INICIALIZACAO_2, paramInit2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.parametroDeInstancia1DoFragmento = getArguments().getString(BlankFragment.PARAMETRO_DE_INICIALIZACAO_1);
            this.parametroDeInstancia2DoFragmento = getArguments().getString(BlankFragment.PARAMETRO_DE_INICIALIZACAO_2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank,container,false);
        return view;
    }



}
