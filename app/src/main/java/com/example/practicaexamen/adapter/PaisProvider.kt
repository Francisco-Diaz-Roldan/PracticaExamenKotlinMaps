package com.example.practicaexamen.adapter

import com.example.practicaexamen.domain.Pais
import com.example.practicaexamen.R

class PaisProvider {
    companion object{
        val listaPaises =  mutableListOf<Pais>(
            Pais(1, "Albania", R.drawable.b_albania, R.drawable.c_vacia, R.drawable.m_albania, "3.038.594", "Tirana", "false", 41.3275, 19.8187),
            Pais(2, "Alemania", R.drawable.b_alemania, R.drawable.c_europa, R.drawable.m_alemania, "81.305.856", "Berlín", "true", 51.1657, 10.4515),
            Pais(3, "Austria", R.drawable.b_austria, R.drawable.c_europa, R.drawable.m_austria, "8.219.743", "Viena", "true", 47.5162, 14.5501),
            Pais(4, "Bélgica", R.drawable.b_belgica, R.drawable.c_europa, R.drawable.m_belgica, "10.438.353", "Bruselas", "true", 50.8503, 4.3517),
            Pais(5, "Bulgaria", R.drawable.b_bulgaria, R.drawable.c_vacia, R.drawable.m_bulgaria, "7.037.935", "Sofía", "false", 42.7339, 25.4858),
            Pais(6, "Rep.Checa", R.drawable.b_chequia, R.drawable.c_europa, R.drawable.m_chequia, "10.177.300", "Praga", "true", 50.0755, 14.4378),
            Pais(7, "Dinamarca", R.drawable.b_dinamarca, R.drawable.c_europa, R.drawable.m_dinamarca, "5.543.453", "Copenague", "true", 56.2639, 9.5018),
            Pais(8, "España", R.drawable.b_espana, R.drawable.c_europa, R.drawable.m_espana, "47.042.984", "Madrid", "true", 40.4168, -3.7038),
            Pais(9, "Estonia", R.drawable.b_estonia, R.drawable.c_europa, R.drawable.m_estonia, "1.274.709", "Tallin", "true", 58.5953, 25.0136),
            Pais(10, "Finlandia", R.drawable.b_finlandia, R.drawable.c_europa, R.drawable.m_finlandia, "5.262.930", "Helsinki", "true", 60.1695, 24.9354),
            Pais(11, "Francia", R.drawable.b_francia, R.drawable.c_europa, R.drawable.m_francia, "65.630.692", "París", "true", 46.6035, 1.8883),
            Pais(12, "Grecia", R.drawable.b_grecia, R.drawable.c_europa, R.drawable.m_grecia, "10.767.827", "Atenas", "true", 39.0742, 21.8243),
            Pais(13, "Holanda", R.drawable.b_holanda, R.drawable.c_europa, R.drawable.m_holanda, "16.730.632", "Amsterdam", "true", 52.3676, 4.9041),
            Pais(14, "Irlanda", R.drawable.b_irlanda, R.drawable.c_europa, R.drawable.m_irlanda, "4.722.028", "Dublín", "true", 53.3498, -6.2603),
            Pais(15, "Islandia", R.drawable.b_islandia, R.drawable.c_europa, R.drawable.m_islandia, "338.349", "Reikiavik", "true", 64.9631, -19.0208),
            Pais(16, "Italia", R.drawable.b_italia, R.drawable.c_europa, R.drawable.m_italia, "61.261.254", "Roma", "true", 41.8719, 12.5674),
            Pais(17, "Noruega", R.drawable.b_noruega, R.drawable.c_vacia, R.drawable.m_noruega, "5.214.890", "Oslo", "false", 60.4720, 8.4689),
            Pais(18, "Portugal", R.drawable.b_portugal, R.drawable.c_europa, R.drawable.m_portugal, "10.781.459", "Lisboa", "true", 38.7223, -9.1393),
            Pais(19, "Rumanía", R.drawable.b_rumania, R.drawable.c_europa, R.drawable.m_rumania, "21.848.504", "Bucarest", "true", 45.9432, 24.9668),
            Pais(20, "Rusia", R.drawable.b_rusia, R.drawable.c_vacia, R.drawable.m_rusia, "142.905.200", "Moscú", "false", 55.7558, 37.6176),
            Pais(21, "Suecia", R.drawable.b_suecia, R.drawable.c_europa, R.drawable.m_suecia, "9.103.788", "Estocolmo", "true", 60.1282, 18.6435),
            Pais(22, "Suiza", R.drawable.b_suiza, R.drawable.c_vacia, R.drawable.m_suiza, "8.140.000", "Berna", "false", 46.8182, 8.2275),
            Pais(23, "Reino Unido", R.drawable.b_uk, R.drawable.c_vacia, R.drawable.m_uk, "65.217.975", "Londres", "false", 51.5099, -0.1180),
            Pais(24, "Ucrania", R.drawable.b_ucrania, R.drawable.c_vacia, R.drawable.m_ucrania, "36.744.636", "Kiev", "false", 50.4501, 30.5234)
        )
    }
}