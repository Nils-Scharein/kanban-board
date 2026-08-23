import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import { heyApiPlugin } from '@hey-api/vite-plugin';

// https://vite.dev/config/
export default defineConfig({
  plugins: [react(),
    heyApiPlugin({
      config: {
        input: 'http://localhost:8080/v3/api-docs',
        output: 'src/__generated_client__',
      },
    }),
  ],
})
